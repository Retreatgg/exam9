<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <div class="container content">
        <h2>My profile</h2>
        <div class="wallet-card mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <h3>👋 Hi ${user.username}!</h3>
                    <h1>Your personal account number: ${user.getPersonalAccountNumber()}</h1>
                    <h1>Your balance: ${user.getAmountMoney()} som</h1>
                </div>
                <div>
                    <button class="btn btn-outline-primary">Send a payment</button>
                    <button class="btn btn-outline-primary">Request a payment</button>
                </div>
            </div>
        </div>

        <table class="table mt-3">
            <thead>
            <tr>
                <th scope="col">Transactions ID</th>
                <th scope="col">Name</th>
                <th scope="col">Date</th>
                <th scope="col">Status</th>
                <th scope="col">Amount</th>
            </tr>
            </thead>
            <tbody>
            <#list transactions as t>
                <#if user.getPersonalAccountNumber() == t.getFromAccountId()>
                    <tr>
                        <td>${t.getId()}</td>
                        <td>${t.toAccountId}</td>
                        <td>08 Jan, 2022</td>
                        <td>Отправлено</td>
                        <td class="text-danger">${t.getAmount()}</td>
                    </tr>
                <#else>
                    <tr>
                        <td>${t.getId()}</td>
                        <td>${t.getFromAccountId()}</td>
                        <td>08 Jan, 2022</td>
                        <td>Поступило</td>
                        <td class="text-success">${t.getAmount()}</td>
                    </tr>
                </#if>
            </#list>

            </tbody>
        </table>
    </div>

</@main.layout>
