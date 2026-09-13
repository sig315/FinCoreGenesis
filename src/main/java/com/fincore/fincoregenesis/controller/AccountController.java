package com.fincore.fincoregenesis.controller;

import com.fincore.fincoregenesis.entity.Account;
import com.fincore.fincoregenesis.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "account-register";
    }

    @PostMapping("/register")
    public String register(
            @Valid Account account,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "account-register";
        }

        accountService.registerAccount(account);
        return "account-register-success";
    }

    @GetMapping
    public String showAccountList(Model model) {
        model.addAttribute("accounts", accountService.findAllAccounts());
        return "account-list";
    }

    @GetMapping("/{id}")
    public String showAccountDetail(
            @PathVariable Long id,
            Model model) {

        Account account = accountService.findAccountById(id);
        model.addAttribute("account", account);
        return "account-detail";
    }

    @GetMapping("/{id}/deposit")
    public String showDepositForm(
            @PathVariable Long id,
            Model model) {

        Account account = accountService.findAccountById(id);

        model.addAttribute("account", account);

        return "account-deposit";
    }

    @PostMapping("/{id}/deposit")
    public String deposit(
            @PathVariable Long id,
            BigDecimal amount,
            Model model) {

        Account account = accountService.depositAccount(id, amount);

        if (account == null) {
            Account currentAccount = accountService.findAccountById(id);
            model.addAttribute("account", currentAccount);
            model.addAttribute("errorMessage", "入金額は1円以上で入力してください。");
            return "account-deposit";
        }

        return "redirect:/accounts/" + id;
    }

    @GetMapping("/{id}/withdraw")
    public String showWithdrawForm(
            @PathVariable Long id,
            Model model) {

        Account account = accountService.findAccountById(id);

        model.addAttribute("account", account);

        return "account-withdraw";
    }

    @PostMapping("/{id}/withdraw")
    public String withdraw(
            @PathVariable Long id,
            BigDecimal amount,
            Model model) {

        Account account = accountService.withdrawAccount(id, amount);

        if (account == null) {
            Account currentAccount = accountService.findAccountById(id);
            model.addAttribute("account", currentAccount);
            model.addAttribute(
                    "errorMessage",
                    "出金額が不正です。残高を超える出金はできません。"
            );
            return "account-withdraw";
        }

        return "redirect:/accounts/" + id;
    }

}