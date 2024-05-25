<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <style>
        .error-container {
            background: #fff;
            padding: 2rem;
            border-radius: 0.5rem;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .error-container h1 {
            font-size: 3rem;
            color: #dc3545;
        }

        .error-container p {
            font-size: 1.2rem;
            color: #6c757d;
        }

        .error-container a {
            margin-top: 1rem;
        }
    </style>

    <div class="error-container">
        <h1><@spring.message "error.oops"/>!</h1>
        <p>${errorMessage}</p>
        <a href="/" class="btn btn-primary"><@spring.message "error.home"/></a>
    </div>
</@main.layout>