public class Main {
    public static void validateUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Логин имеет недопустимую длинну или недопустимые символы");
        }
        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Пароль имеет недопустимую длинну или недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void main(String[] args) {
        String login = "java_skyprokkkkkk*";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_";

        try {
            validateUser(login, password, confirmPassword);
            System.out.println("Регистрация успешна");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}

