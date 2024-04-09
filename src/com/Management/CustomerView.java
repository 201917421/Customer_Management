package com.Management;

/**
 * ClassName:CustomerView
 * Package: com.Management
 * Description:
 *
 * @Author Joan Jia
 * @Create 2024/3/29 15:33
 * @Version 1.0
 */
public class CustomerView {
    public static void main(String[] args) {
        CustomerView p1=new CustomerView();
        p1.enterMainMenu();
    }


    //创建一个最大包含10个客户的对象数组
    CustomerList customerList=new CustomerList(10);

    public void enterMainMenu(){
        boolean flag=true;

        do{
            System.out.println("------------拼电商客户管理系统------------");
            System.out.println();
            System.out.println("1 添加客户");
            System.out.println("2 修改客户");
            System.out.println("3 删除客户");
            System.out.println("4 客户列表");
            System.out.println("5 退\t出");
            System.out.println();
            System.out.println("请选择（1-5）：");
            char w=CMUtility.readMenuSelection();//封装的工具类,键入一个数字
            switch(w){
                case '1':
                    this.addNewCustomer();
                    break;
                case '2':
                    this.modifyCustomer();
                    break;
                case '3':
                    this.deleteCustomer();
                    break;
                case '4':
                    this.listAllCustomers();
                    break;
                case '5':
                    flag=false;
                    System.out.println("成功退出！");
                    break;
            }
        }while(flag);


    }

    //主页面添加客户流程
    private void addNewCustomer(){
        Customer customer=new Customer();//每次调用该方法都会新创建一个客户对象。
        System.out.println("------------添加客户------------");
        System.out.print("姓名：");
        String name=CMUtility.readString(10);
        customer.setName(name);//给客户姓名赋值
        System.out.print("性别：");
        char gender=CMUtility.readChar();
        customer.setGender(gender);
        System.out.print("年龄：");
        int age=CMUtility.readInt();
        customer.setAge(age);
        System.out.print("电话：");
        String phone=CMUtility.readString(11);
        customer.setPhone(phone);
        System.out.print("邮箱：");
        String email=CMUtility.readString(30);
        customer.setEmail(email);
        customerList.addCustomer(customer);//将新创建的对象加入客户列表。

    }
    private void modifyCustomer(){
        System.out.println("------------修改客户------------");
        System.out.println("请选择待修改客户编号（-1退出）：");//使用return返回一个空值
        int num=CMUtility.readInt();
        if(num==-1){//如果输入的是-1，则退出，返回一个空值。
            return;
        }else{
            Customer customer=customerList.getCustomers(num);//获取编号是num的客户对象。
            System.out.print("姓名("+customer.getName()+")：");
            String name = CMUtility.readString(4, customer.getName());
            System.out.print("性别("+customer.getGender()+")：");
            char gender = CMUtility.readChar(customer.getGender());
            System.out.print("年龄("+customer.getAge()+")：");
            int age = CMUtility.readInt(customer.getAge());
            System.out.print("电话（"+customer.getPhone()+")：");
            String phone = CMUtility.readString(15, customer.getPhone());
            System.out.print("邮箱（"+customer.getEmail()+")：");
            String email = CMUtility.readString(15, customer.getEmail());

            Customer cust=new Customer(name,gender,age,phone,email);
            boolean flag=customerList.replaceCustomer(num,cust);//将新修改的替换掉原来的。
            if(flag){
                System.out.println("已成功修改！");
            }else{
                System.out.println("修改失败！");
            }

        }
            /*
            Customer customer=customerList.getCustomers(num);//获取编号是num的客户对象。

            System.out.print("姓名("+customer.getName()+")：");
            String name=CMUtility.readString(10);
            if(name.equals("\n")){
                //这里第二个参数如果name是回车符则不修改，返回值和getName一样.
                String name1=CMUtility.readString(10, customer.getName());
                customer.setName(name1);
            }else//如果不是回车符，则修改成输入的名字
                customer.setName(name);

            System.out.print("性别("+customer.getGender()+")：");
            char gen=CMUtility.readChar();
            if(gen=='\n'){
                //这里第二个参数如果gen是回车符则不修改，返回值和getName一样.
                char gender=CMUtility.readChar(customer.getGender());
                customer.setGender(gender);
            }else//如果不是回车符，则修改成输入的名字
                customer.setGender(gen);


            System.out.print("年龄("+customer.getAge()+")：");
            int age=CMUtility.readInt();
            char c=(char)age;
            if(c=='\n'){
                //这里第二个参数如果gen是回车符则不修改，返回值和getName一样.
                int age1=CMUtility.readInt(customer.getAge());
                customer.setAge(age1);
            }else//如果不是回车符，则修改成输入的年龄
                customer.setAge(age);


            System.out.print("电话（"+customer.getPhone()+")：");
            String phone=CMUtility.readString(11);
            if(phone.equals("\n")){
                String phone1=CMUtility.readString(11,customer.getPhone());
                customer.setPhone(phone1);
            }else{
                customer.setPhone(phone);
            }

            System.out.print("邮箱（"+customer.getEmail()+")：");
            String email0=CMUtility.readString(30);
            if(email0.equals("\n")){
                String email1=CMUtility.readString(30,customer.getEmail());
                customer.setEmail(email1);
            }else{
                customer.setEmail(email0);
            }
            System.out.println("------------修改完成------------");
        }

             */

    }

    //查看客户列表
    public void listAllCustomers(){
        System.out.println("------------客户列表------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
        Customer[] customers=customerList.getAllCustomers();
        for(int i=0;i<customerList.getTotal();i++){
            System.out.println(i+"\t\t"+customers[i].getName()+"\t\t"+customers[i].getGender()+"\t\t"+customers[i].getAge()+"\t\t"+customers[i].getPhone()+"\t\t"+customers[i].getEmail());
        }
    }

    //删除客户
    public void deleteCustomer(){
        System.out.println("------------删除客户------------");
        System.out.println("请选择待删除的客户编号（-1退出）");
        int num=CMUtility.readInt();
        if(num==-1){//如果输入的是-1，则退出，返回一个空值。
            return;
        }else{
            System.out.print("确认是否删除(Y/N)：");
            char yn = CMUtility.readConfirmSelection();
            if (yn == 'N')
                return;
            boolean flag=customerList.deleteCustomer(num);
            if(flag){
                System.out.println("删除成功！");
            }else{
                System.out.println("您输入有误，删除失败！");
            }
        }
    }

}
