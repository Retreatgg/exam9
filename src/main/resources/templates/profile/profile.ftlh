<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <div class="container content">
        <div class="w-100 mb-3 bg-primary rounded mt-2 text-white p-4 d-flex justify-content-between align-items-center">
            <h2 class=""><@spring.message "profile.my.profile"/></h2>
            <h3>👋 <@spring.message "profile.hi"/> ${user.username}!</h3>
        </div>
        <div class="wallet-card mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <h1 class="fs-2"><@spring.message "profile.personal.account"/>
                        : ${user.getPersonalAccountNumber()?c}</h1>
                    <h1 class="fs-3"><@spring.message "profile.your.balance"/>: ${user.getAmountMoney()?c} som</h1>
                </div>
                <div>
                    <button
                            class="btn btn-outline-primary"
                            data-toggle="modal"
                            data-target="#sendPaymentModal"
                    >
                        <@spring.message "profile.send.a.payment"/>
                    </button>
                    <button class="btn btn-outline-primary" data-toggle="modal" data-target="#topUpYourAccountModal">
                        <@spring.message "profile.top.up.account"/>
                    </button>
                </div>
            </div>
        </div>

        <#if transactions?size gt 0>
            <table class="table mt-3 rounded border border-2">
                <thead>
                <tr>
                    <th scope="col"><@spring.message "profile.transaction.id"/></th>
                    <th scope="col"><@spring.message "profile.name"/></th>
                    <th scope="col"><@spring.message "profile.date"/></th>
                    <th scope="col"><@spring.message "profile.status"/></th>
                    <th scope="col"><@spring.message "profile.amount"/></th>
                </tr>
                </thead>
                <tbody>
                <#list transactions as t>

                    <#if t.getFromAccountId()??>
                        <#if user.getPersonalAccountNumber()?c == t.getFromAccountId()?c>
                            <#if t.toAccountId??>
                                <tr>
                                    <td>${t.getId()}</td>
                                    <td>${t.toAccountId?c}</td>
                                    <td>${t.getTransactionTime()}</td>
                                    <td><@spring.message "profile.send"/></td>
                                    <td class="text-danger">- ${t.getAmount()?c} som</td>
                                </tr>
                            <#else>
                                <tr>
                                    <td>${t.getId()}</td>
                                    <td>${t.toProviderId?c}</td>
                                    <td>${t.getTransactionTime()}</td>
                                    <td><@spring.message "profile.paid"/></td>
                                    <td class="text-danger">- ${t.getAmount()?c} som</td>
                                </tr>
                            </#if>
                        <#else>

                            <tr>
                                <td>${t.getId()}</td>
                                <td>${t.getFromAccountId()?c}</td>
                                <td>${t.getTransactionTime()}</td>
                                <td><@spring.message "profile.received"/></td>
                                <td class="text-success">+ ${t.getAmount()?c} som</td>
                            </tr>
                        </#if>
                    <#else>
                        <tr>
                            <td>${t.getId()}</td>
                            <td>Terminal</td>
                            <td>${t.getTransactionTime()}</td>
                            <td><@spring.message "profile.received"/></td>
                            <td class="text-success">+ ${t.getAmount()?c} som</td>
                        </tr>
                    </#if>
                </#list>
                </tbody>
            </table>
            <#else>
            <h3><@spring.message "profile.not.transactions"/></h3>
        </#if>
    </div>



    <div class="modal fade" id="sendPaymentModal" tabindex="-1" role="dialog" aria-labelledby="sendPaymentModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="sendPaymentModalLabel"><@spring.message "profile.send.a.payment"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/transaction/send" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control" id="toAccountNumber" name="toAccountNumber"
                                   placeholder="<@spring.message "profile.enter.account.number"/>">
                        </div>

                        <div class="form-group">
                            <input type="number" class="form-control" id="amount" name="amount"
                                   placeholder="<@spring.message "profile.enter.amount"/>">
                        </div>
                        <div class="modal-footer">
                            <button type="submit"
                                    class="btn btn-primary"><@spring.message "profile.send.a.payment"/></button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


    <div class="modal fade" id="topUpYourAccountModal" tabindex="-1" role="dialog"
         aria-labelledby="sendPaymentModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="sendPaymentModalLabel"><@spring.message "profile.top.up.account"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/profile/top_up" method="POST">
                        <div class="form-group">
                            <input type="number" class="form-control" id="amount" name="amount"
                                   placeholder="<@spring.message "profile.enter.amount"/>">
                        </div>
                        <div class="modal-footer">
                            <button type="submit"
                                    class="btn btn-primary"><@spring.message "profile.top.up.account"/></button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

</@main.layout>
