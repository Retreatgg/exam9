<#import "../layout.ftlh" as main>
<@main.layout>

    <div class="container my-4">
        <#if number??>
            <h3 class="fs-4">Ваши реквизиты: ${number}</h3>
        </#if>
        <h3 class="fs-4">Провайдер: ${provider.name}</h3>
        <button id="unique" class="btn btn-outline-primary">Получить уникальный номер счета</button>
        <button class="btn btn-outline-primary" data-toggle="modal" data-target="#payAccountModal">Оплатить счет
        </button>
        <div id="accountNumberContainer" class="mt-3"></div>
    </div>

    <div class="modal fade" id="payAccountModal" tabindex="-1" role="dialog" aria-labelledby="payAccountModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="payAccountModalLabel">Оплата счета</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/provider/pay_account" method="POST">
                        <div class="form-group">
                            <label for="accountNumber">Уникальный номер счета</label>
                            <input type="text" class="form-control" id="accountNumber" name="accountNumber"
                                   placeholder="Введите номер счета">
                        </div>
                        <div class="form-group">
                            <label for="amount">Сумма</label>
                            <input type="number" class="form-control" id="amount" name="amount"
                                   placeholder="Введите сумму">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-primary">Оплатить</button>
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
                body: JSON.stringify(${provider.id})
            });
        });
    </script>
</@main.layout>
