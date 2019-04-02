package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("tmc", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Klinin");
            user.setBirthDate(new Date(32432423423525221L));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            User b = loadedObject.users.get(0);
            System.out.println(javaRush.equals(loadedObject));//here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            boolean usersIsEmpty = users.isEmpty();
            if (usersIsEmpty==true){
                writer.println("true");
                writer.flush();//implement this method - реализуйте этот метод
            } else {
                writer.println("false");
                for(User user:users){
                    writer.println(user.getFirstName() + " " + user.getLastName() + " " + user.getBirthDate().getTime() + " "
                            + Boolean.toString(user.isMale()) + " " + user.getCountry().getDisplayName());
                }
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().compareTo("false")==0) {
                while (reader.ready()) {
                    String[] user = reader.readLine().split(" ");
                    User user1 = new User();
                    user1.setFirstName(user[0]);
                    user1.setLastName(user[1]);
                    Date d = new Date();
                    d.setTime(Long.parseLong(user[2]));
                    user1.setBirthDate(d);
                    System.out.println(user[3]);
                    user1.setMale(Boolean.valueOf(user[3]));
                    user1.setCountry(User.Country.valueOf(user[4].toUpperCase()));
                    users.add(user1);//implement this method - реализуйте этот метод
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
