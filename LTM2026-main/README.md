# LTM2026 - Java Network Programming

## Giới thiệu
Đây là repository tổng hợp các bài thực hành môn **Lập trình mạng** bằng Java.

### Nội dung
- TCP Socket
- UDP Socket
- Java RMI
- SOAP Web Service (JAX-WS)
- Byte Stream, Character Stream, Object Stream

## Cấu trúc dự án

```text
LTM2026/
├── src/
│   ├── TCP/
│   ├── UDP/
│   ├── RMI/
│   ├── WS/
│   └── WebService/
├── nbproject/
├── build.xml
├── manifest.mf
└── README.md
```

## Yêu cầu
- JDK 17+
- NetBeans IDE
- Apache Ant (Đi thi sử dụng Ant nhé, đừng sử dụng Maven không thì bị lỗi đấy) 

*Lưu ý khi làm bài về WS (Netbeans)
- B1: Chuột phải vào Project
- B2: New -> Web Service Cilent
- B3: Chọn WSDL URL -> Dán URL mà đề bài cho
- B4: Sau khi đợi tất cả file đã hiện ra, vào phần Generated Source, sẽ thấy Folder ptit\dblab\judge\network\server\soap
- B5: Kéo folder đó vào Source Package, sau đó Code như bình thường

## License
Chỉ phục vụ mục đích học tập.
