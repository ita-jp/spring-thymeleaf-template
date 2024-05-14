package com.example.app.controller.admin.book;

import com.example.app.service.book.BookService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class AdminBookController {

    private final BookService bookService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "admin/book/index";
    }

    @GetMapping("/new")
    public String newForm(@ModelAttribute("form") BookForm form) {
        return "admin/book/new";
    }

    @PostMapping
    public String create(@ModelAttribute("form") @Validated BookForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/book/new";
        }
        bookService.register(form.title(), form.author());
        return "redirect:/admin/books";
    }

    public record BookForm(
            @NotBlank
            @Size(max = 256)
            String title,

            @NotBlank
            @Size(max = 256)
            String author
    ) {
    }
}
