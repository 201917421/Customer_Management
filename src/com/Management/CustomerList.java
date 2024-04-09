package com.Management;

/**
 * ClassName:CustomerList
 * Package: com.Management
 * Description:内部使用数组管理一组Customer对象
 *
 * @Author Joan Jia
 * @Create 2024/3/29 14:18
 * @Version 1.0
 */
public class CustomerList {
    private Customer[] customers;
    private int total=0;//记录已保存客户对象的数量

    public CustomerList(int totalCustomer) {
        //在创建此类构造器的同时创建客户对象数组
        customers=new Customer[totalCustomer];//totalCustomer记录数组最大容量
    }
    public int getTotal(){
        return total;
    }

    //添加客户
    public boolean addCustomer(Customer customer){
        if(this.getTotal()<customers.length){//如果当前数组未满，返回true
            this.customers[total]=customer;
            this.total++;
            System.out.println("添加成功");
            return true;
        }else //如果当前数组已满，返回false
            return false;
    }

    //修改客户信息,用cust替代索引是index的客户
    public boolean replaceCustomer(int index,Customer cust){
        if(index>=this.getTotal()||index<0||this.getTotal()==0){
            System.out.println("您输入的用户不存在，请重新输入");
            return false;
        }else{
            customers[index]=cust;
            return true;
        }
    }
    //删除客户,删除索引是index的客户
    public boolean deleteCustomer(int index){
        if(index>=this.getTotal()||index<0){
            return false;
        }else{
            for(int i=index;i<this.total;i++){
                Customer temp=customers[index];
                customers[index]=customers[index+1];
                customers[index+1]=temp;
            }
            System.out.println("已成功删除！");
            return true;
        }
    }

    //查询客户列表
    public Customer[] getAllCustomers(){
        return customers;
    }

    //查询索引是index的客户信息
    public Customer getCustomers(int index){
        return customers[index];
    }



    //作单元测试，测试该类中的方法是否正确执行
    public static void main(String[] args) {
        CustomerList customerLists=new CustomerList(5);
        Customer cust1=new Customer();
        Customer cust2=new Customer();
        cust1.setName("甄嬛");
        cust1.setAge(21);
        cust1.setGender('女');
        cust1.setEmail("zijincheng@123.com");
        cust1.setPhone("1254867651");

        cust2.setName("大胖橘");
        cust2.setAge(40);
        cust2.setGender('男');
        cust2.setEmail("yangxindian@123.com");
        cust2.setPhone("256842349");
        //添加客户
        customerLists.addCustomer(cust1);
        customerLists.addCustomer(cust2);
        //修改客户
        customerLists.replaceCustomer(0,cust2);
        //删除客户
        customerLists.deleteCustomer(3);
        Customer[] customers=customerLists.getAllCustomers();
        for(int i=0;i<customerLists.getTotal();i++){
            System.out.println("姓名："+customers[i].getName()+",年龄："+customers[i].getAge()+",性别："+customers[i].getGender()+",电话："+customers[i].getPhone()+",邮箱："+customers[i].getEmail());
        }

        customerLists.getCustomers(1);


    }
}
