INSERT INTO  course(id,name) VALUES(1,'Jpa');
INSERT INTO  course(id,name) VALUES(2,'Hibernate');
INSERT INTO  course(id,name) VALUES(3,'Java');
INSERT INTO  course(id,name) VALUES(4,'Sql');
INSERT INTO  course(id,name) VALUES(5,'Spring boot');
INSERT INTO  course(id,name) VALUES(6,'Ruby');

INSERT INTO  review(id,rating,description,course_id) VALUES(1,'5','Very nice course',1);
INSERT INTO  review(id,rating,description,course_id) VALUES(2,'5','Very nice course',2);
INSERT INTO  review(id,rating,description,course_id) VALUES(3,'4','Very nice course',3);
INSERT INTO  review(id,rating,description,course_id) VALUES(4,'3','Very nice course',4);
INSERT INTO  review(id,rating,description,course_id) VALUES(5,'5','Very nice course',5);
INSERT INTO  review(id,rating,description,course_id) VALUES(6,'2','Very nice course',6);


INSERT INTO  pasport(id,number) VALUES(1,'E124587');
INSERT INTO  pasport(id,number) VALUES(2,'E25894');
INSERT INTO  pasport(id,number) VALUES(3,'E8560124');
INSERT INTO  pasport(id,number) VALUES(4,'E78945213');
INSERT INTO  pasport(id,number) VALUES(5,'E658790');
INSERT INTO  pasport(id,number) VALUES(6,'E012369');

INSERT INTO  student(id,name,pasport_id) VALUES(1,'Nasim',1);
INSERT INTO  student(id,name,pasport_id) VALUES(2,'Kabir',2);
INSERT INTO  student(id,name,pasport_id) VALUES(3,'Nayeem',3);
INSERT INTO  student(id,name,pasport_id) VALUES(4,'Jannat',4);
INSERT INTO  student(id,name,pasport_id) VALUES(5,'Shahadat',5);
INSERT INTO  student(id,name,pasport_id) VALUES(6,'Masum',6);

INSERT INTO student_course(student_id,course_id) VALUES(1,1);
INSERT INTO student_course(student_id,course_id) VALUES(2,2);
INSERT INTO student_course(student_id,course_id) VALUES(3,3);
INSERT INTO student_course(student_id,course_id) VALUES(4,4);
INSERT INTO student_course(student_id,course_id) VALUES(5,5);
INSERT INTO student_course(student_id,course_id) VALUES(6,6);
