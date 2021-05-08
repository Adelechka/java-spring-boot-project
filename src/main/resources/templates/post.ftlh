<div class="col-md-6 offset-md-3 mb-3">
    <div class="card">
        <div class="card-header">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <a href="/post_id${post.post.id}" class="btn btn-dark">${post.post.comments?size}
                    комментариев >> </a>
                <#if auth == true>
                    <#if auth_user_id == post.post.author.id>
                        <form style="margin-bottom: 0" method="post" action="/delete_post${post.post.id}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input class="btn btn-danger" type="submit" value="Удалить">
                        </form>
                    </#if>
                </#if>
            </div>
        </div>
        <div class="card-body">
            <#if post.post.picture??>
                <img src="media?name=${post.post.picture}" class="card-img-top" alt="...">
            </#if>
            <blockquote class="blockquote mb-0">
                <p>${post.post.text}</p>
                <p class="text-end">
                    <img src="/media?name=${post.post.author.photos}" class="img-raised rounded-circle"
                         style="width: 30px; margin-bottom: 0rem">

                    <span class="align-text-top"><a class="fst-italic" href="/id${post.post.author.id}">
                        ${post.post.author.login} </span>
                    </a>
                </p>
            </blockquote>
        </div>
        <div class="card-footer text-end text-muted">

            <#if auth == true>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <#if post.isLiked == 0>
                        <form style="margin-bottom: 0" method="post" action="/like_post${post.post.id}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <button class="btn btn-primary me-md-2" type="submit">${post.post.likes?size} <i
                                        class="fas fa-heart"></i>
                                Мне нравится
                            </button>
                        </form>
                    <#elseif post.isLiked == 1>
                        <form style="margin-bottom: 0" method="post" action="/dislike_post${post.post.id}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <button class="btn btn-primary" type="submit">${post.post.likes?size} <i
                                        class="fas fa-heart-broken"></i>
                                Больше не нравится
                            </button>
                        </form>
                    </#if>
                </div>
            <#else>
                ${post.post.likes?size} <i class="far fa-heart"></i> Мне нравится
            </#if>
        </div>
    </div>
</div>
