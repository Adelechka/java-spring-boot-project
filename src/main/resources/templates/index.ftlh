<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftlh">
    <!-- Custom styles for this template -->
    <title>Главная</title>
    <link href="headers.css" rel="stylesheet">
    <link href="styles/profile.css" rel="stylesheet">
</head>

<body class="profile-page">

<#include "header.ftlh">

<div class="page-header header-filter" data-parallax="true"></div>
<div class="main main-raised">
    <div class="profile-content">
        <div class="container">

            <div class="tab-content tab-space">
                <div class="tab-pane active text-center gallery" id="studio">
                    <div class="row">

                        <#list posts as post>
                            <div class="col-md-6 offset-md-3 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <blockquote class="blockquote mb-0">
                                            <p>${post.text}</p>
                                            <footer class="blockquote-footer">
                                                <a href="/id${post.author.id}">
                                                    <cite title="Source Title">${post.author.login}</cite>
                                                </a>
                                            </footer>
                                        </blockquote>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
                <div class="tab-pane text-center gallery" id="works">
                    <div class="row">
                        <div class="col-md-3 ml-auto">
                            <img src="https://images.unsplash.com/photo-1524498250077-390f9e378fc0?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=83079913579babb9d2c94a5941b2e69d&auto=format&fit=crop&w=751&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1506667527953-22eca67dd919?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6326214b7ce18d74dde5e88db4a12dd5&auto=format&fit=crop&w=750&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1505784045224-1247b2b29cf3?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=ec2bdc92a9687b6af5089b335691830e&auto=format&fit=crop&w=750&q=80"
                                 class="rounded"></div>
                        <div class="col-md-3 mr-auto">
                            <img src="https://images.unsplash.com/photo-1504346466600-714572c4b726?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6754ded479383b7e3144de310fa88277&auto=format&fit=crop&w=750&q=80"
                                 class="rounded">
                            <img src="https://images.unsplash.com/photo-1494028698538-2cd52a400b17?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=83bf0e71786922a80c420c17b664a1f5&auto=format&fit=crop&w=334&q=80"
                                 class="rounded">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "footer.ftlh">

</body>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
        integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
        integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
        crossorigin="anonymous"></script>
</html>

