import java.util.Scanner;
import java.util.InputMismatchException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[6];

        books[0] = new ProgrammingBook(001, "Clean code", 150.0, "Robert C.Martin", "java", "none");
        books[1] = new ProgrammingBook(002, "Code Complete", 200.0, "Nguyễn Thái Hưng", "Java, C++,Python", "none");
        books[2] = new ProgrammingBook(003, "The Pragmatic Programmer", 210.0, "Nguyễn Thái Hưng", "Java, C++,Python", "none");

        books[3] = new FictionBook(004, "Tam thể", 100.0, "Lưu Từ Hân", "Viễn tưởng");
        books[4] = new FictionBook(005, "Animorphs (Người Hóa Thú)", 110.0, "K.A. Applegate", "Viễn tưởng 1");
        books[5] = new FictionBook(006, "Hai Vạn Dặm Dưới Biển (Twenty Thousand Leagues Under the Sea)", 99.0, "Jules Verne", "Viễn tưởng 1");

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\n====== Menu ======");
            System.out.println("1. Đếm và liệt kê sách lập trình(ProgrammingBook)");
            System.out.println("2. Đếm và liệt kê sách Viễn tưởng(FictionBook)");
            System.out.println("3. Đếm và liệt kê sách lập trình Java, C++,Python");
            System.out.println("4. Đếm và liệt kê sách Viễn tưởng loại 'Viễn tưởng 1'");
            System.out.println("5. Đếm và liệt kê sách Viễn tưởng giá <100");
            System.out.println("6. Tính tổng tiền tất cả sách(sau giảm giá)");
            System.out.println("0. Thoát");
            System.out.println("======================");
            System.out.println("Nhập lựa chọn của mày vào đây cho tao: ");
            try {
                choice = scanner.nextInt(); // đọc lựa chọn
                //Xử lý lựa chọn bằng swith-case
                switch (choice) {
                    case 1:
                        countAndListProgrammingBooks(books);
                        break;
                    case 2:
                        countAndListFictionBooks(books);
                        break;
                    case 3:
                        countAndListJCPProgrammingBooks(books);
                        break;
                    case 4:
                        countAndListFictionbooksCategobry(books, "Viễn tưởng 1");
                        break;
                    case 5:
                        countAndListFictionPricelessThan(books, 100.0);
                        break;
                    case 6:
                        calculateTotalPrice(books);
                        break;
                        case 0:
                            System.out.println("Tạm biệt!");
                            break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ,chọn lại đi đồ ngoo");
                }
                // đầu vào k phải số nguyên
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng chỉ nhập số nguên,");
                scanner.next();// đọc bỏ giá trị không hợp lệ
                choice = -1; // đặt lại choice để vòng lặp tiếp tục
            }
            System.out.println();
        } while (choice != 0);// lặp lại cho đến khi chọn
        scanner.close();
    }
    public static void countAndListProgrammingBooks(Book[] books) {
        System.out.println("\n--- Sách lập trình(ProgrammingBook) ---");
        int count = 0;
        for (Book book : books) {
            if (book instanceof ProgrammingBook) {
                count++;
                System.out.println(book.toString());//in thoong tin sach
            }
        }
        if (count == 0) {
            System.out.println("không tìm thấy sách lập trình: " + count);
        }
    }
    public static void countAndListFictionBooks(Book[] books) {
        System.out.println("\n---Sách Viễn tưởng(FictionBook) ---");
        int count = 0;
        for (Book book : books) {
            if (book instanceof FictionBook) {
                count++;
                System.out.println(book.toString());
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy sách Viễn tưởng: " + count);
        }
    }
    public static void countAndListJCPProgrammingBooks(Book[] books) {
        System.out.println("\n---Sách lập trình Java, C++,Python");
        int count = 0;
        for (Book book : books) {
            if (book instanceof ProgrammingBook) {
                ProgrammingBook pb = (ProgrammingBook) book;
                if ("Java, C++,Python".equals(pb.getLanguage())) {
                    count++;
                    System.out.println(book.toString());
                }
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy sách lập trình Java, C++,Python nào.");
        } else {
            System.out.println("=> Tổng số sách lập trình Java, C++,Python: " + count);
        }
    }
    public static void countAndListFictionbooksCategobry(Book[] books, String targetCategory) {
        System.out.println("\n--- Sách Viễn tưởng Categobry: '"+targetCategory+"'---");
        int count = 0;
        boolean found = false;
        for (Book book : books) {
            if (book instanceof FictionBook) {
                FictionBook fb = (FictionBook) book;
                if(targetCategory.equals(fb.getCategory())) {
                    count++;
                    System.out.println(book.toString());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách viễn tưởng nào thuộc category '" + targetCategory + "'.");
        }else {
            System.out.println("=> Tổng số sách viễn tưởng category '" + targetCategory + "': " + count);
        }
    }
    public static void countAndListFictionPricelessThan(Book[] books, double maxPrice) {
        System.out.println("\n--- Sách Viễn tưởng Giá <" + maxPrice + "---");
        int count = 0;
        for (Book book : books) {
            if (book instanceof FictionBook) {
              //book.getPrice() sẽ tự động gọi phương thức getPrice()
                if (book.getPrice() < maxPrice) {
                    count++;
                    System.out.println(book.toString() + "-Giá sau khi giảm: "+String.format("%.2f", book.getPrice()));
                    //in cả giá để kiểm tra
                }
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy sách viễn tưởng nào có giá < " + maxPrice + ".");
        }else {
            System.out.println("=> Tổng số sách viễn tưởng giá <" + maxPrice + ": " + count);
        }
    }
    public static void calculateTotalPrice(Book[] books) {
        System.out.println("\n--- Tổng tiền tất cả sách ---");
        double totalPrice = 0;
        for (Book book : books) {
            if (book != null) {
                totalPrice += book.getPrice();
            }
        }
        System.out.printf("Tổng tiền của tất cả sách(sau khi đã giảm giá): %.2f%n", totalPrice);
    }
}

    //===========================
//        double totalPrice = 0;
//        for (Book book : books) {
//            if (book != null) {
//                totalPrice += book.getPrice();
//            }
//        }
//        System.out.println("Tổng tiền 6 cuốn sách: " + totalPrice);
//        System.out.printf(" (Định dạng: %.2f)%n", totalPrice);
//
//        int javabookCount = 0;
//        for (Book book : books) {
//            if (book instanceof ProgrammingBook) {
//                ProgrammingBook pb = (ProgrammingBook) book;
//                if ("Java, C++,Python".equals(pb.getLanguage())) {
//                    javabookCount++;
//                }
//            }
//        }
//        System.out.println("Số sách ProgrammingBook có ngôn ngữ Java, C++,Python: " + javabookCount);
//
//        int fictionbookCount = 0;
//        for (Book book : books) {
//            if (book instanceof FictionBook) {
//                FictionBook fb = (FictionBook) book;
//                if ("Viễn tưởng".equals((fb.getCategory()))) {
//                    fictionbookCount++;
//                }
//            }
//        }
//        System.out.println("Số sách Fictionbook có loại Viễn tưởng: " + fictionbookCount);
//
//        int fictionPriceCount = 0;
//        for (Book book : books) {
//            if (book instanceof FictionBook) {
//                if (book.getPrice() > 100) {
//                    fictionPriceCount++;
//                }
//            }
//        }
//        System.out.println("Số sách Fictionbook có giá (sau khi giảm) nhỏ hơn 100:" + fictionPriceCount);
//        ;
//    }
//}