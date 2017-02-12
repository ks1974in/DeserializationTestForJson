package in.cloudnine.serverframework.data.interfaces.root;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import in.cloudnine.serverframework.data.interfaces.root.DataReference;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public abstract class DataReferenceImpl implements DataReference{

public Class getDataClass(){
	return this.getClass();
}

@Override
public String toString() {
	System.out.println("toString:"+this.getClass().getName());
	
	return (hasField("name")?getValue("name").toString():(hasField("serialNumber")?getValue("serialNumber").toString():super.toString()));
}

@Override
public String getId() {
	return(String) getValue(getDataClass().getSimpleName()+"Id");
	}



protected Object getValue(String name){

	try{
		
	return  getField(name).get(this);
	}
	catch(IllegalAccessException e){
		e.printStackTrace();
	}
	return null;
}



protected Field getField(String name){
	Class clazz=getDataClass();
    for(Field field:getAllFields(clazz)){
        if(field.getName().equalsIgnoreCase(name)){
        	field.setAccessible(true);
            return field;
        }
    }
    throw new NullPointerException();
	
}

protected  Field[] getAllFields(Class aClass) {
	
    List<Field> fields = new ArrayList<Field>();
    do {
        Collections.addAll(fields, aClass.getDeclaredFields());
        aClass = aClass.getSuperclass();
    } while (aClass != null);
    return fields.toArray(new Field[]{});
}

protected boolean hasField(String name){
    Class clazz=getDataClass();
    for(Field field:getAllFields(clazz)){
        if(field.getName().equalsIgnoreCase(name)){
            return true;
        }
    }
    return false;
}



}
