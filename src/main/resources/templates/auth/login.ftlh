<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <section class="login_section position-relative mt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="login_form-box">
                        <div class="login_form-container">
                            <h2><@spring.message "login.account"/></h2>
                            <form action="/auth/login" method="POST" class="login_form">
                                <div class="form-group mt-2">
                                    <input type="email" class="form-control" name="username" placeholder="<@spring.message "login.enter.email"/>" required>
                                </div>
                                <div class="form-group mt-2">
                                    <input type="password" class="form-control" name="password" placeholder="<@spring.message "login.enter.password"/>" required>
                                </div>
                                <div class="form-group mt-2">
                                    <button type="submit" class="btn custom_dark-btn btn-block"><@spring.message "login.login"/></button>
                                </div>
                            </form>
                            <div class="text-center">
                                <p class="small fw-bold mt-2 pt-1 mb-0"><@spring.message "login.haven't.account"></@spring.message> <a href="/auth/register"
                                                                                                                                       class="link-danger"><@spring.message "login.register"></@spring.message></a>
                                </p>
                                <p class="small fw-bold mt-2 pt-1 mb-0"><a href="/auth/forgot_password"><@spring.message "login.forgot.password"></@spring.message></a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</@main.layout>