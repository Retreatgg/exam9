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
                    <button class="btn btn-outline-primary"  data-toggle="modal" data-target="#sendPaymentModal">Send a payment</button>
                    <button class="btn btn-outline-primary" data-toggle="modal" data-target="#topUpYourAccountModal">Top up your account</button>
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

    <div class="modal fade" id="sendPaymentModal" tabindex="-1" role="dialog" aria-labelledby="sendPaymentModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="sendPaymentModalLabel">Send a Payment</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/transaction/send" method="POST">
                        <div class="form-group">
                            <label for="toAccountNumber">Recipient Account Number</label>
                            <input type="text" class="form-control" id="toAccountNumber" name="toAccountNumber" placeholder="Enter account number">
                        </div>
                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter amount">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Send Payment</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


    <div class="modal fade" id="topUpYourAccountModal" tabindex="-1" role="dialog" aria-labelledby="sendPaymentModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="sendPaymentModalLabel">Send a Payment</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/profile/top_up" method="POST">
                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter amount">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Send Payment</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

</@main.layout>
