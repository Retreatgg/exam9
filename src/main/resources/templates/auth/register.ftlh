<#import "../layout.ftlh" as main>
<@main.layout>

    <section class="register_section position-relative mt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="register_form-box">
                        <div class="register_form-container">
                            <h2>Register New Account</h2>
                            <form action="/auth/register" method="POST" class="register_form">
                                <div class="form-group mt-2">
                                    <input type="text" class="form-control" name="username" placeholder="Username" required>
                                </div>
                                <div class="form-group mt-2">
                                    <input type="email" class="form-control" name="email" placeholder="Email" required>
                                </div>
                                <div class="form-group mt-2">
                                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                                </div>
                                <div class="form-group mt-2">
                                    <button type="submit" class="btn custom_dark-btn btn-block">Register</button>
                                </div>
                            </form>
                            <div class="text-center">
                                <p>Already have an account? <a href="/auth/login">Login Here</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</@main.layout>