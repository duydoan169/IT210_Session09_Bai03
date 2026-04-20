package org.example.bai3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Bai3Controller {

    @PostMapping("/change-theme")
    public String changeTheme(@RequestParam("theme") String theme, HttpServletResponse response) {
        // 1. Tạo Cookie với tên "app_theme"
        Cookie themeCookie = new Cookie("app_theme", theme);

        // 2. Thiết lập thời hạn sống: 30 ngày (tính bằng giây)
        // 30 ngày * 24 giờ * 60 phút * 60 giây = 2,592,000 giây
        themeCookie.setMaxAge(30 * 24 * 60 * 60);

        // 3. Bật cờ HttpOnly để chống Hacker truy cập qua JavaScript (XSS)
        themeCookie.setHttpOnly(true);

        // 4. Đảm bảo Cookie có hiệu lực trên toàn bộ trang web
        themeCookie.setPath("/");

        // 5. Gửi Cookie về trình duyệt khách hàng
        response.addCookie(themeCookie);

        return "redirect:/";
    }

    @GetMapping("/")
    public String index(
            @CookieValue(value = "app_theme", defaultValue = "light") String currentTheme,
            Model model
    ) {
        // Đưa giá trị theme vào model để View (Thymeleaf/JSP) render đúng CSS
        model.addAttribute("theme", currentTheme);

        // Logic hiển thị lời chào hoặc danh sách sản phẩm...
        return "index";
    }
}