<header class="header">
    <nav class="navbar navbar-expand-lg fixed-top py-3">
        <div class="container"><a href="#" class="navbar-brand text-uppercase font-weight-bold"><i
                        class="fab fa-reddit"></i> Reddit</a>
            <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"
                    class="navbar-toggler navbar-toggler-right"><i class="fa fa-bars"></i></button>

            <div id="navbarSupportedContent" class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a href="/" class="nav-link text-uppercase font-weight-bold"><i
                                    class="fas fa-home"></i> Главная</a>
                    </li>

                    <#if isAdmin == true>
                        <li class="nav-item"><a href="/manageUsers" class="nav-link text-uppercase font-weight-bold"><i
                                        class="fas fa-cogs"></i> Пользователи</a></li>
                    </#if>
                    <#if auth == false>
                        <li class="nav-item"><a href="/signIn" class="nav-link text-uppercase font-weight-bold"> <i
                                        class="fas fa-sign-in-alt"></i> Войти</a></li>
                    <#else>
                        <li class="nav-item"><a href="/profile" class="nav-link text-uppercase font-weight-bold"><i
                                        class="fas fa-user"></i> Моя страница</a></li>
                        <li class="nav-item"><a href="/logout" class="nav-link text-uppercase font-weight-bold"> <i
                                        class="fas fa-sign-out-alt"></i> Выйти</a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>
