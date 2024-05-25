<#import "../layout.ftlh" as main>
<@main.layout>

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
                    <form action="/anonim/top_up" method="POST">
                        <div class="form-group">
                            <label for="amount">Your account number</label>
                            <input type="number" class="form-control" id="amount" name="accountNumber" placeholder="Enter amount">
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






    <style>
        .card {
            width: 140px;
            height: 100px;
            text-align: center;
        }

        .card-text {
            line-height: 1.5;
            font-size: 1rem;
        }
    </style>

    <body>
    <div class="container my-4">
        <div class="d-flex justify-content-between align-items-center mb-2">
            <#if user??>
                <h1>Your balance: ${user.getAmountMoney()}</h1>
            <#else>
                <button class="btn btn-outline-primary" data-toggle="modal" data-target="#topUpYourAccountModal">Top up your account anonim</button>
            </#if>
        </div>
    </div>



</@main.layout>