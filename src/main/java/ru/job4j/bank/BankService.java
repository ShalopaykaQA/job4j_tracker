package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс хранит всех пользователей и их счета.
 * Реализует функционал перевода денег.
 *
 * @author Эльвира (mailto:shalopayka@gmail.com).
 * @version 1.
 * @since 29.12.2020.
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод реализует добавление нового клиента.
     *
     * @param user Новый пользователь, которого нужно добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод реализует добавление нового счета клиенту.
     *
     * @param passport Паспортные данные клиента, которому нужно добавить счет.
     * @param account  Новый счет, который нужно добавить.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод реализует получение счета клиента по паспорту клиента и реквизитам.
     *
     * @param passport Паспортные данные клиента, счет которого нужно получить.
     * @return Возвращает клента. Если клиента нет, возвращает пустой объект.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод реализует получение счета клиента по паспорту клиента и реквизитам.
     *
     * @param passport  Паспортные данные клиента, счет которого нужно получить.
     * @param requisite Реквизиты счета, который нужно получить.
     * @return Возвращает счет. Если счета нет, возвращает пустой объект.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод реализует перевод денег между счетами.
     *
     * @param srcPassport   Паспортные данные клиента, со счета которого нужно перевести деньги.
     * @param srcRequisite  Реквизиты счета, с которого нужно перевести деньги.
     * @param destPassport  Паспортные данные клиента, на счет которого нужно перевести деньги.
     * @param destRequisite Реквизиты счета, на который нужно перевести деньги.
     * @param amount        Сумма денег, которую нужно перевести.
     * @return true, если перевод успешен, в противном случае вренет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}