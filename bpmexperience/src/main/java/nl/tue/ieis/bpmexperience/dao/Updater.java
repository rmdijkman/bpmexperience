package nl.tue.ieis.bpmexperience.dao;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class Updater {

	public static <E> E update(E oldEntity, E newEntity) {

		Field[] newEntityFields = newEntity.getClass().getDeclaredFields();
		Hashtable<String, Object> newHT = fieldsToHT(newEntityFields, newEntity);

		Class<? extends Object> oldEntityClass = oldEntity.getClass();
		Field[] oldEntityFields = oldEntityClass.getDeclaredFields();

		for (Field field : oldEntityFields){
			field.setAccessible(true);
			Object o = newHT.get(field.getName());
			if (o != null){
				try {
					Field f = oldEntityClass.getDeclaredField(field.getName());
					f.setAccessible(true);
					f.set(oldEntity, o);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
			}

		}

		return oldEntity;
	}

	private static Hashtable<String, Object> fieldsToHT(Field[] fields, Object obj){
		Hashtable<String,Object> hashtable = new Hashtable<>();
		for (Field field: fields){
			field.setAccessible(true);
			try {
				Object retrievedObject = field.get(obj);
				if (retrievedObject != null){
					hashtable.put(field.getName(), field.get(obj));
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return hashtable;
	}
}