<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <div class="container my-4">
        <#if number??>
            <h3 class="fs-4"><@spring.message "provider.your.req"/>: ${number?c}</h3>
        </#if>
        <h3 class="fs-4"><@spring.message "provider.provider"/>: ${provider.name}</h3>
        <button id="unique" class="btn btn-outline-primary"><@spring.message "provider.get.unique.account"/></button>
        <button class="btn btn-outline-primary" data-toggle="modal" data-target="#payAccountModal"><@spring.message "provider.paid"/>
        </button>
        <div id="accountNumberContainer" class="mt-3"></div>
    </div>

    <div class="modal fade" id="payAccountModal" tabindex="-1" role="dialog" aria-labelledby="payAccountModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="payAccountModalLabel"><@spring.message "provider.bill.payment"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/provider/pay" method="POST">

                        <div class="form-group">
                            <label for="accountNumber"><@spring.message "provider.unique.account"/></label>
                            <input type="text" class="form-control" id="accountNumber" name="requisites"
                                   placeholder="<@spring.message "profile.enter.account.number"/>">
                        </div>
                        <div class="form-group">
                            <label for="amount">Сумма</label>
                            <input type="number" class="form-control" id="amount" name="amount"
                                   placeholder="<@spring.message "profile.enter.amount"/>">
                        </div>

                        <input type="hidden" name="accountProvider" value="${provider.account}">
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary"><@spring.message "provider.pay"/></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.getElementById('unique').addEventListener('click', async () => {

            const response = await fetch('/provider/unique/account', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(${provider.account})
            });
        });
    </script>
</@main.layout>
