package ru.javawebinar.basejava.serialization;

import java.io.*;

public class SerialMain {
    public static void main(java.lang.String[] args) {
       Point p1 = new Point(1.0,1.0);
       Point p2 = new Point(2.0,2.0);
       Point p3 = new Point(3.0,3.0);
       Line line1 = new Line(p1,p2,1);
       Line line2 = new Line(p2,p3,2);
       System.out.println("line 1 = " + line1);
       System.out.println("line 2 = " + line2);
       String fileName = "d:\\file";
       try{
          // записываем объекты в файл
          FileOutputStream os = new FileOutputStream(fileName);
          ObjectOutputStream oos = new ObjectOutputStream(os);
          oos.writeObject(line1);
          oos.writeObject(line2);
          // меняем состояние line1 и записываем его еще раз
          line1.setIndex(3);
          oos.reset();
          oos.writeObject(line1);
          // закрываем потоки
          // достаточно закрыть только поток-надстройку
          oos.close();
          // считываем объекты
          System.out.println("Read objects:");
          FileInputStream is = new FileInputStream(fileName);
          ObjectInputStream ois = new ObjectInputStream(is);
          for (int i=0; i<3; i++) { // Считываем 3 объекта
             Line line = (Line)ois.readObject();
             line.printInfo();
          } ois.close();
       } catch(ClassNotFoundException e) {
          e.printStackTrace();
       } catch(IOException e) {
          e.printStackTrace();
       }
    }
 }
