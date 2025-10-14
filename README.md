# Thuật ngữ cơ bản ----
===================================================================================================== 
| Thuật ngữ             | Giải thích                                                                |
| --------------------- | ------------------------------------------------------------------------- |
| **Repository (Repo)** | Nơi lưu trữ mã nguồn (có thể là thư mục trên máy hoặc trên GitHub).       |
| **Commit**            | Một “bản chụp” (snapshot) của mã nguồn tại thời điểm đó.                  |
| **Branch**            | Một nhánh làm việc riêng (thường có nhánh chính là `main` hoặc `master`). |
| **Merge**             | Gộp các thay đổi từ một branch vào branch khác.                           |
| **Clone**             | Sao chép repo từ GitHub về máy.                                           |
| **Pull**              | Lấy thay đổi mới nhất từ GitHub về.                                       |
| **Push**              | Gửi thay đổi từ máy bạn lên GitHub.                                       |
_____________________________________________________________________________________________________
=====================================================================================================
# Luật commit code ----
| Type         | Ý nghĩa                                           | Ví dụ                                                    |
| ------------ | ------------------------------------------------- | -------------------------------------------------------- |
| **feat**     | Thêm tính năng mới                                | `feat(api): add AES-256 encryption for message`          |
| **fix**      | Sửa lỗi                                           | `fix(auth): incorrect key size during decryption`        |
| **docs**     | Chỉnh sửa tài liệu                                | `docs(readme): update usage guide for encryption module` |
| **style**    | Sửa format, indent, space (không ảnh hưởng logic) | `style(core): reformat code with clang-format`           |
| **refactor** | Cải tiến cấu trúc code (không đổi hành vi)        | `refactor(crypto): split cipher functions into modules`  |
| **test**     | Thêm / sửa test                                   | `test(auth): add unit tests for key validation`          |
| **chore**    | Công việc phụ trợ (config, CI, dependency...)     | `chore(ci): add GitHub action for code scanning`         |
| **perf**     | Tối ưu hiệu suất                                  | `perf(core): reduce encryption overhead by 20%`          |
| **revert**   | Hoàn tác commit cũ                                | `revert: remove deprecated AES256 fallback`              |
_______________________________________________________________________________________________________________________________
===============================================================================================================================
# Luật commit lên branch ----
| Mục đích      | Tên nhánh   |
| ------------- | ------------|
| Tính năng mới | `feature`   |
| Sửa bug       | `bugfix`    |
| Viết tài liệu | `docs`      |
| Thử nghiệm    | `experiment`|
_______________________________
===============================

# Luật mở đầu file ----
// ==============================================================
// #Author: Người viết script
// #Date: ngày tạo ra
// #Description: mô tả script này làm gì
// ==============================================================
// ==============================================================
// -------------------- IMPLEMENTATION --------------------------
// Thực thi code import thư viện class...
//
// ---- Main program ----
// #chương trình chính
//
// --------------------------------------------------------------
// ==============================================================
// ---- END ---

# Quy tắt file và thư mục ----
| Loại                      | Quy tắc                                                | Ví dụ đúng                                 |
| ------------------------- | ------------------------------------------------------ | ------------------------------------------ |
| **Tên file (class)**      | Viết theo **PascalCase** (mỗi từ viết hoa chữ cái đầu) | `LoginController.java`, `UserService.java` |
| **Tên package (thư mục)** | Viết **chữ thường**, cách nhau bằng dấu `.`            | `com.example.app`, `org.company.security`  |
| **Tên interface**         | PascalCase, thường bắt đầu bằng danh từ/đặc tính       | `Encryptable.java`, `Runnable.java`        |
| **Tên enum**              | PascalCase                                             | `UserType.java`                            |
| **Tên abstract class**    | PascalCase, có thể thêm tiền tố `Abstract`             | `AbstractEncryption.java`                  |
| **Tên exception class**   | PascalCase, kết thúc bằng `Exception`                  | `InvalidKeyException.java`                 |
| **Tên annotation**        | PascalCase, thường không có hậu tố                     | `@Secure`, `@Deprecated`                   |                        
| **Tên Thư mục**           | viết thường, có thể dùng -                             | `encryption-app`, `user-security-service`  |
# Quy tắt đặt tên Package trong java
| Trường                                             | Mẫu package chuẩn      | Ví dụ cụ thể                       |
| -------------------------------------------------- | ---------------------- | ---------------------------------- |
| **Đại học Bách Khoa Hà Nội (HUST)**                | `edu.hust.<project>`   | `edu.hust.librarysystem.model`     |
| **Đại học Công nghệ Thông tin – ĐHQG HCM (UIT)**   | `edu.uit.<project>`    | `edu.uit.studentportal.controller` |
| **Đại học Bách Khoa TP.HCM (HCMUT)**               | `edu.hcmut.<project>`  | `edu.hcmut.chatapp.service`        |
| **Học viện Công nghệ Bưu chính Viễn thông (PTIT)** | `edu.ptit.<project>`   | `edu.ptit.bankingsystem.ui`        |
| **Đại học FPT**                                    | `edu.fpt.<project>`    | `edu.fpt.ecommerceapp.model`       |
| **Đại học Khoa học Tự nhiên (HCMUS)**              | `edu.hcmus.<project>`  | `edu.hcmus.imageeditor.main`       |
| **Đại học CNTT – HUTECH**                          | `edu.hutech.<project>` | `edu.hutech.inventorysystem.dao`   |
| **Đại học Công Nghệ Sài Gòn – STU**                | `edu.stu.<project>`    | `edu.stu.inventorysystem.dao`      |


# Cây cấu trúc
src/
└── edu/
    └── stu/
        └── cipherapp/
            ├── main/
            │   └── CipherApp.java          ← Điểm khởi động chương trình
            │
            ├── view/
            │   ├── MainFrame.java          ← Giao diện chính (Swing)
            │   ├── CipherPanel.java        ← Panel chứa các trường nhập/xuất
            │   └── MenuBar.java            ← Thanh menu (File, Help...)
            │
            ├── controller/
            │   ├── CipherController.java   ← Điều khiển giữa UI và logic
            │   └── ActionHandler.java      ← Xử lý các sự kiện Button
            │
            ├── model/
            │   ├── CipherAlgorithm.java    ← Interface API cho các thuật toán
            │   ├── CaesarCipher.java       ← Thuật toán Caesar
            │   ├── VigenereCipher.java     ← Thuật toán Vigenère
            │   └── PlayfairCipher.java     ← Thuật toán Playfair
            │
            ├── utils/
            │   ├── TextValidator.java      ← Kiểm tra chuỗi đầu vào
            │   ├── FileUtils.java          ← Lưu/đọc file mã hóa
            │   └── CipherFactory.java      ← Khởi tạo thuật toán phù hợp
            │
            └── constants/
                └── CipherType.java         ← Enum: CAESAR, VIGENERE, PLAYFAIR




#**Lưu ý**: Đặt tên rõ ràng mô tả đúng nội dung mà nó có thể làm được một cách ngắn gọn. (VD: xử lý mã hóa cipher = XuLyMHCipher.java)




