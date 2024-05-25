<#import "spring.ftl" as spring>
<#macro layout>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bank Profile and Transactions</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .navbar-nav .nav-link {
                color: white !important;
            }
            .table thead th {
                background-color: #f8f9fa;
            }
            .table td, .table th {
                vertical-align: middle;
            }
            .text-success {
                color: #28a745 !important;
            }
            .text-danger {
                color: #dc3545 !important;
            }
            .profile {
                background-color: #2C2F48;
                color: white;
                padding: 10px;
            }
        </style>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
       <div class="container">
           <a class="navbar-brand" href="/">Bank</a>
           <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
           </button>
           <div class="collapse navbar-collapse" id="navbarNav">
               <#assign known = SPRING_SECURITY_CONTEXT??>
               <ul class="navbar-nav">
                   <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                           <@spring.message "layout.change.lang"/>
                       </a>
                       <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                           <li><a class="dropdown-item" href="?lang=ru" onclick="changeLanguage('ru')"><@spring.message "layout.ru"/></a></li>
                           <li><a class="dropdown-item" href="?lang=en"  onclick="changeLanguage('en')"><@spring.message "layout.en"/></a></li>
                       </ul>
                   </li>
               </ul>
               <ul class="navbar-nav ml-auto">
                   <#if known>
                       <a href="/profile" class="btn btn-outline-info m-2"><@spring.message "layout.profile"/></a>
                       <a href="/logout" class="btn btn-outline-info m-2" id="logout"><@spring.message "layout.logout"/></a>
                   <#else>
                       <a href="/auth/login" class="btn btn-outline-info m-2"><@spring.message "layout.login"/></a>
                       <a href="/auth/register" class="btn btn-outline-info m-2"><@spring.message "layout.register"/></a>
                   </#if>
               </ul>
           </div>
       </div>
    </nav>
    <div class="container">
        <#nested spring>
    </div>
    </body>

    <script>
        function changeLanguage(lang) {
            let headers = new Headers;
            headers.set('Content-Type', 'application/json');
            fetch('/profile/change_language', {
                method: 'POST',
                headers,
                body: new URLSearchParams({ lang: lang })
            }).then(() => {
                window.location.reload();
            });
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </html>

</#macro>
