# Assignment Title: Rescue Robot System (Interface + Composition)

## Student Information
- Name: Phacarapon
- Student ID: [68122250086]
- Submission Date: [19/02/2026]


## Problem Description

โปรแกรมนี้เป็นระบบจำลองหุ่นยนต์กู้ภัย (Rescue Robot)  
ที่สามารถบิน เคลื่อนที่ ตรวจจับความร้อน และส่งข้อความพร้อมพิกัดได้

เป้าหมายของงานคือ:
- แสดงแนวคิด OOP อย่างเป็นระบบ
- แก้ปัญหา Multiple Inheritance ใน Java
- ใช้ Interface + Composition แทนการสืบทอดหลาย class

Scenario ที่รองรับ:
- หุ่นยนต์บินไปยังตำแหน่งเป้าหมาย
- ตรวจจับอุณหภูมิเพื่อค้นหามนุษย์
- ส่งข้อความรายงานพร้อมพิกัดปัจจุบัน
- ทุก action ต้องใช้พลังงานจาก Battery


### 1) Java สืบทอดหลาย class ไม่ได้เพราะอะไร

Java ไม่อนุญาตให้ class หนึ่ง `extends` ได้มากกว่า 1 class  
เพื่อป้องกันปัญหา **Diamond Problem**

ตัวอย่างปัญหา:
- Class A มี method ชื่อ start()
- Class B และ C สืบทอดจาก A
- Class D สืบทอดจาก B และ C

ถ้า B และ C override start() ต่างกัน  
D จะไม่สามารถตัดสินใจได้ว่าจะใช้ของใคร

เพื่อหลีกเลี่ยง Java จึง:
- อนุญาตให้ extends ได้เพียง 1 class
- แต่สามารถ implements ได้หลาย interface

### 2) เราใช้ Interface + Composition แทนอย่างไร

เนื่องจากไม่สามารถสืบทอดหลาย class ได้  
เราจึงใช้ 2 แนวคิดแทน

#### (A) Interface → รวม “ความสามารถ”

RescueRobot implements:

- Flyable
- Movable
- Communicable
- Detectable

Interface กำหนดสิ่งที่ class ต้องทำ  
แต่ไม่เก็บข้อมูลภายใน

ตัวอย่าง:

```java
public class RescueRobot 
    implements Flyable, Movable, Communicable, Detectable
```

### 3) อธิบายการแก้ปัญหา default method ชื่อชนกัน

interface สามารถมี `default method` ได้
ซึ่งหมายความว่า interface สามารถมี implementation ภายในได้

ปัญหาเกิดขึ้นเมื่อ:

- Class หนึ่ง implements หลาย interface
- และ interface เหล่านั้นมี default method ชื่อเดียวกัน

ตัวอย่าง:

```java
interface A {
    default void start() {
        System.out.println("Start from A");
    }
}

interface B {
    default void start() {
        System.out.println("Start from B");
    }
}

class C implements A, B { }
```

วิธีแก้ปัญหา
Class ที่ implements ต้อง override method นั้นเองอย่างชัดเจน

ตัวอย่าง:
```java
class C implements A, B {

    @Override
    public void start() {
        A.super.start();   // เลือกใช้ของ A
    }
}
```
หรือสามารถเขียน implementation ใหม่เองได้:
```java
@Override
public void start() {
    System.out.println("Custom start implementation");
}
```
