package ru.javawebinar.basejava.serialization;

import java.io.Serializable;

public class Point implements Serializable {
   double x;
   double y;
   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }
   public String toString() {
      return "("+x+","+y+") reference="+super.toString();
   }
}