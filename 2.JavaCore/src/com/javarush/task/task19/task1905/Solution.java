package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {

            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String code = null;
            for (Map.Entry<String,String> item : countries.entrySet()) {
                if (item.getValue().equals(customer.getCountryName())) {
                    code = item.getKey();
                }
            }
            return code;
        }

        @Override
        public String getCompany() {
            String s = customer.getCompanyName();
            return s;
        }

        @Override
        public String getContactFirstName() {
            String [] a = contact.getName().split(" ");
            return a[1];
        }

        @Override
        public String getContactLastName() {
            String [] a = contact.getName().split(",");
            return a[0];
        }

        @Override
        public String getDialString() {
            String a = contact.getPhoneNumber();
            String phone = "callto://+";

            for (int i = 0; i < a.length(); i++){
                if (Character.isDigit(a.charAt(i))){
                    phone += a.charAt(i);
                }
            }
            return phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}