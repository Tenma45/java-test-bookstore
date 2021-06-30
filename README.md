# Bookstore Application

## สิ่งที่ต้องทำ

1. ทำการออกแบบ RESTful APIs  

|Method|URL|Usage|Request|Response|
| --- | --- | --- | --- |---| 
|GET|/book| เรียกดูหนังสือทั้งหมด | - | หนังสือทั้งหมด     |
|POST|/book|    เพิ่มหนังสือ(เล่มเดียว) | ข้อมูลหนังสือ | หนังสือที่เพิ่มเข้าไป     |
|POST|/books|    เพิ่มลิสต์ของหนังสือ(หลายเล่ม) | ลิสต์ของข้อมูลหนังสือ | ลิสต์ของหนังสือที่เพิ่มเข้าไป     |
|PUT|/book|    ซื้อหนังสือ | ลิสต์ของออเดอร์ | ราคาที่ต้องจ่าย     |

2. ทำการออกแบบ Database structure สำหรับจัดเก็บข้อมูลของระบบงาน
### Book
|Field|Type|Definition|Property|
| --- | --- | --- | --- |
|volume|Integer| หมายเลขเล่ม | Id |
|title|String| ชื่อภาค | - |
|count|Integer| จำนวนของหนังสือ | - | 
### BookOrder
|Field|Type|Usage|Key|
| --- | --- | --- | --- |
|volume|Integer| หมายเลขเล่ม | - |
|count|Integer|  จำนวนที่ซื้อ | ข้อมูลหนังสือ |

3. ทำการพัฒนา RESTful API ด้วย Spring Boot (Controller layer, Service layer, Repository layer, and Gateway layer)

https://github.com/Tenma45/java-test-bookstore

4. ทำการทดสอบระบบงานที่พัฒนาด้วย Spring Boot
### ทดสอบบน Browser
![Browser Test](https://github.com/Tenma45/java-test-bookstore/blob/main/markdown/browserTest.png)
### ทดสอบด้วย Unit test
![Browser Test](https://github.com/Tenma45/java-test-bookstore/blob/main/markdown/unitTest.png)

5. API testing with Postman
### ทดสอบ Add Books
![add Books Test](https://github.com/Tenma45/java-test-bookstore/blob/main/markdown/addBooks.png)
### ทดสอบ Get Books
![get Books Test](https://github.com/Tenma45/java-test-bookstore/blob/main/markdown/getBooks.png)
### ทดสอบ Buy Books
![buy Books Test](https://github.com/Tenma45/java-test-bookstore/blob/main/markdown/buyBooks.png)

6. ทำการจัดการ version ของ source code ผ่านระบบ Git + GitHub

https://github.com/Tenma45/java-test-book-store/commits/main

 ~~7. ทำการออกแบบและสร้าง pipeline ของระบบงานบน Jenkins (Build, Test, Deploy)~~

8. เขียน Unit Test

https://github.com/Tenma45/java-test-book-store/tree/main/src/test/java/com/example/bookstore
