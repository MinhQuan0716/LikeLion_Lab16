import java.util.ArrayList;
import java.util.Scanner;

public class App {
     static ArrayList<Contact> listContact=new ArrayList<Contact>();
    public static void Showmenu(){
        System.out.println("1/ Hiển thị danh sách liên lạc");
        System.out.println("2/ Tìm kiếm liên lạc theo mã liên lạc");
        System.out.println("3/ Thêm mới liên lạc");
        System.out.println("4/ Sửa thông tin liên lạc ");
        System.out.println("5/ Xóa thông tin liên lạc ");
        System.out.println("Mờibạnchọnchức năng [1->5] hoặc nhấn phím khác để thoát");
    }
    public static boolean HandleChoice(String choice){
        Scanner scanner=new Scanner(System.in);
          switch (choice) {
            case "1":
              if (listContact.isEmpty()) {
                    System.out.println("No contacts available.");
                } else {
                    for (Contact contact : listContact) {
                        System.out.println(contact);
                    }
                }
                break;
            case "2":
                                 System.out.print("Enter ID to search: ");
                int searchId = scanner.nextInt();
                scanner.nextLine();
                boolean found = false;
                for (Contact contact : listContact) {
                    if (contact.getId() == searchId) {
                        System.out.println("Found: " + contact);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Contact not found.");
                }

                break;
            case "3" :
           boolean validId = false;
    int newId = 0;

    while (!validId) {
        System.out.print("Enter ID: ");
        newId = scanner.nextInt();

        boolean isDuplicate = false;
        for (Contact contact : listContact) {
            if (contact.getId() == newId) {
                System.out.println("Duplicate ID! Please enter another one.");
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            validId = true;
        }
    }
             
                scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Email: ");
                String email = scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Enter Address: ");
                String address = scanner.nextLine();

                listContact.add(new Contact(newId, name, email, phoneNumber, address));
                System.out.println("Contact added.");
                break;
            case "4":
              System.out.print("Enter ID to update: ");
                int updateId = scanner.nextInt();
                scanner.nextLine();

                Contact contactToUpdate = null;
                for (Contact c : listContact) {
                    if (c.getId() == updateId) {
                        contactToUpdate = c;
                        break;
                    }
                }

                if (contactToUpdate == null) {
                    System.out.println("Contact not found.");
                    break;
                }

                System.out.print("New Name (leave blank to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.isBlank()) contactToUpdate.setName(newName);

                System.out.print("New Email (leave blank to keep current): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isBlank()) contactToUpdate.setEmail(newEmail);

                System.out.print("New Phone Number (leave blank to keep current): ");
                String newPhone = scanner.nextLine();
                if (!newPhone.isBlank()) contactToUpdate.setPhoneNumber(newPhone);

                System.out.print("New Address (leave blank to keep current): ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isBlank()) contactToUpdate.setAddress(newAddress);

                System.out.println("Contact updated.");
                break;
            case "5":
             System.out.print("Enter ID to delete: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine();

                boolean removed = listContact.removeIf(c -> c.getId() == deleteId);
                if (removed) {
                    System.out.println("Contact deleted.");
                } else {
                    System.out.println("Contact not found.");
                }
                break;
            default:
            System.out.println("Exiting");
                return true;
        
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        boolean exit=false;
        while(!exit){
        Showmenu();
        System.out.println("Nhap lua chon");
        String choice=scanner.nextLine();
        exit=HandleChoice(choice);
    }
}
}
