package ru.andr.javadaddy.advanced.test.topic2.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void withdraw_success() {
        Account account = new Account("username", 500.00);

        when(accountRepository.findAccountById("username")).thenReturn(account);

        assertTrue(accountService.withdraw("username", 150.00));

        verify(accountRepository, times(1)).findAccountById("username");
        verify(accountRepository, times(1)).updateAccount(account);
    }

    @Test
    void withdraw_lackOfFunds() {
        Account account = new Account("username", 100.00);

        when(accountRepository.findAccountById("username")).thenReturn(account);

        assertFalse(accountService.withdraw("username", 150.00));

        verify(accountRepository, times(1)).findAccountById("username");
        verify(accountRepository, times(0)).updateAccount(account);
    }

    @Test
    void withdraw_accountNotFound() {
        Account account = new Account("username", 100.00);

        when(accountRepository.findAccountById("username")).thenReturn(null);

        assertFalse(accountService.withdraw("username", 150.00));

        verify(accountRepository, times(1)).findAccountById("username");
        verify(accountRepository, times(0)).updateAccount(account);
    }
}
