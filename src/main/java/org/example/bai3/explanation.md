Phần 1 - Báo cáo phân tích và Thiết kế giải pháp

Xác định công cụ: Chọn Cookie hay Session? Lựa chọn: Cookie.

Tại sao không dùng Session? Session được lưu trữ trên RAM của Server và
định danh qua một SessionID trong bộ nhớ tạm của trình duyệt. 

Khi người dùng tắt trình duyệt (hoặc hết thời gian timeout thường là 30 phút), Session sẽ bị hủy. 
Do đó, nó không thể đáp ứng yêu cầu "nhớ" thiết lập trong 30 ngày.

Ưu điểm của Cookie: Dữ liệu được ghi vào file trên ổ cứng máy tính khách hàng. 
Chúng ta có thể đặt thuộc tính Max-Age để quy định chính xác thời gian tồn tại của nó (30 ngày).

Chặn bẫy dữ liệu XSS (Cross-Site Scripting) Để ngăn chặn Hacker dùng document.cookie 
để đánh cắp hoặc sửa đổi thông tin qua JavaScript, chúng ta phải bật cờ HttpOnly.
Khi cờ này được bật, trình duyệt sẽ ngăn không cho bất kỳ mã JavaScript nào truy cập vào Cookie đó.

Cookie chỉ được gửi qua các HTTP Request lên Server, giúp bảo vệ dữ liệu khỏi các cuộc tấn công XSS phổ biến.