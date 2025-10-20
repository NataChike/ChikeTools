package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ContactForm;
import com.example.demo.service.EmailService;

import jakarta.validation.Valid;

@Controller()
@RequestMapping("/contact")
public class ContactController {
@Autowired
EmailService emailService;
 @GetMapping("")
 public String showContactForm(Model model) {
     if (!model.containsAttribute("contactForm")) {
         model.addAttribute("contactForm", new ContactForm());
     }
     return "contact"; // contact.html をレンダリング
 }

 @PostMapping("")
 public String submitContact(@Valid ContactForm contactForm,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

     if (bindingResult.hasErrors()) {
         // バリデーションエラー: フラッシュでフォームとエラーを引き継ぐ
         redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", bindingResult);
         redirectAttributes.addFlashAttribute("contactForm", contactForm);
         redirectAttributes.addFlashAttribute("errorMessage", "入力にエラーがあります。ご確認ください。");
         return "redirect:/contact";
     }

     // --- ここで問い合わせを処理（保存 or メール送信等） ---
     // 例: EmailService.send(contactForm) を呼ぶ
     emailService.sendContactEmail(contactForm);
     // 成功メッセージ
     redirectAttributes.addFlashAttribute("successMessage", "お問い合わせを受け付けました。返信はメールで行います。");
     return "redirect:/contact";
 }
}

