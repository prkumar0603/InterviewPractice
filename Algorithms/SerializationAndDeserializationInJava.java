/*Serialization is a mechanism of converting the state of an object into a byte stream. 
 Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
 This mechanism is used to persist the object.
		To make a Java object serializable we implement the java.io.Serializable interface.
		The ObjectOutputStream class contains writeObject() method for serializing an Object.
		public final void writeObject(Object obj) 
								throws IOException
		The ObjectInputStream class contains readObject() method for deserializing an object.
		public final Object readObject()
			               throws IOException,
			               ClassNotFoundException
Only the objects of those classes can be serialized which are implementing java.io.Serializable interface.
Serializable is a marker interface (has no data member and method). It is used to “mark” java classes so that objects 
of these classes may get certain capability. Other examples of marker interfaces are:- Cloneable and Remote.
NOTE:1)If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
2)Only non-static data members are saved via Serialization process.
3)Static data members and transient data members are not saved via Serialization process.
4)So, if you don’t want to save value of a non-static data member then make it transient.
5)Constructor of object is never called when an object is deserialized.
6)Associated objects must be implementing Serializable interface.
*/
import java.io.*;
class Demo implements Serializable{
	//if u dont want to save a nonstatic value, make it transient
	int a;
	String b;
	
	Demo(int a,String b){
		this.a = a;
		this.b = b;
	}
}
public class SerializationAndDeserializationInJava {

	public static void main(String[] args) {
    
		Demo objwrite = new Demo(1,"hello!!how do u do");
		String filename = "file.txt";
		
		//storing object in file
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(objwrite);
			
			out.close();
			file.close();
			
			System.out.println("Object has been serialized .");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//now read the file
		Demo objread = null;
		
		try{
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			objread = (Demo)in.readObject();
			
			in.close();
			file.close();
			
			System.out.println("Object Deserialized");
			System.out.println(objread.a);
			System.out.println(objread.b);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        }

	}

}
