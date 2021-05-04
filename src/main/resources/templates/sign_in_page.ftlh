<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script
            src="https://kit.fontawesome.com/64d58efce2.js"
            crossorigin="anonymous"
    ></script>
    <link rel="shortcut icon" href="/img/reddit.png" type="image/png">
    <link rel="stylesheet" href="styles/signInAngUp.css"/>
    <title>Авторизация</title>
</head>
<body>
<div class="container">
    <div class="forms-container">
        <div class="signin-signup">
            <form action="/signIn" method="post" class="sign-in-form">
                <h2 class="title">Войти</h2>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input name="login" type="text" placeholder="Логин" required/>
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input name="password" type="password" placeholder="Пароль" required/>
                </div>
                <label>
                    <input type="checkbox" name="remember-me"> Запомнить меня
                </label>
                <input type="submit" value="Войти" class="btn solid"/>
            </form>
            <form action="/signUp" method="post" class="sign-up-form" enctype="multipart/form-data">
                <h2 class="title">Создать аккаунт</h2>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="input-field">
                    <i class="fas fa-angle-right"></i>
                    <input name="firstName" type="text" placeholder="Имя" required/>
                </div>
                <div class="input-field">
                    <i class="fas fa-angle-right"></i>
                    <input name="lastName" type="text" placeholder="Фамилия" required/>
                </div>
                <div class="input-field">
                    <i class="fas fa-angle-right"></i>
                    <input class="form-control" type="file" name="image" accept="image/png, image/jpeg" placeholder="Выберите файл"/>
                </div>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input name="login" type="text" placeholder="Логин" required/>
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input name="password" type="password" placeholder="Пароль" required/>
                </div>
                <input type="submit" class="btn" value="Создать"/>
            </form>
        </div>
    </div>

    <div class="panels-container">
        <div class="panel left-panel">
            <div class="content">
                <h3>Нет аккаунта ?</h3>
                <p>
                    Создайте аккаунт, чтобы пользоваться сервисом
                </p>
                <button class="btn transparent" id="sign-up-btn">
                    Регистрация
                </button>
            </div>
            <img src="img/sign_in.svg" class="image" alt=""/>
        </div>
        <div class="panel right-panel">
            <div class="content">
                <h3>Уже есть аккаунт ?</h3>
                <p>
                    Войдите в аккаунт, чтобы пользоваться сервисом
                </p>
                <button class="btn transparent" id="sign-in-btn">
                    Войти
                </button>
            </div>
            <img src="img/sign_up.svg" class="image" alt=""/>
        </div>
    </div>
</div>

<script src="js/signInAngUp.js"></script>
</body>
</html>
