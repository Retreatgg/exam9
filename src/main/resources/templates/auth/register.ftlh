<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <section class="register_section position-relative mt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="register_form-box">
                        <div class="register_form-container">
                            <h2><@spring.message "user.create.form"/></h2>
                            <form action="/auth/register" method="POST" class="register_form">
                                <div class="form-group mt-2">
                                    <input type="text" class="form-control" name="username" placeholder="<@spring.message "user.create.your.name"/>" required>
                                </div>
                                <div class="form-group mt-2">
                                    <input type="password" class="form-control" name="password" placeholder="<@spring.message "user.create.your.password"/>" required>
                                </div>
                                <div class="form-group mt-2">
                                    <button type="submit" class="btn custom_dark-btn btn-block"><@spring.message "user.create.btn"/></button>
                                </div>
                            </form>
                            <div class="text-center">
                                <p><@spring.message "user.create.have.account"/>? <a href="/auth/login"><@spring.message "login.login"/></a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</@main.layout>