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
            <tr>
                <td>962296152</td>
                <td>Sherman Blankenship</td>
                <td>08 Jan, 2022</td>
                <td>Pending</td>
                <td class="text-success">$217.90</td>
            </tr>
            <tr>
                <td>829892537</td>
                <td>Claudio Barrera</td>
                <td>06 Jan, 2022</td>
                <td>Completed</td>
                <td class="text-success">$329.90</td>
            </tr>
            <tr>
                <td>741560657</td>
                <td>Clifton Daniel</td>
                <td>03 Jan, 2022</td>
                <td>Completed</td>
                <td class="text-danger">-$549.90</td>
            </tr>
            <tr>
                <td>529040347</td>
                <td>Curt Boyer</td>
                <td>01 Jan, 2022</td>
                <td>Completed</td>
                <td class="text-danger">-$238.90</td>
            </tr>
            <tr>
                <td>398078341</td>
                <td>Jeff Proctor</td>
                <td>31 Dec, 2021</td>
                <td>Completed</td>
                <td class="text-danger">-$283.90</td>
            </tr>
            <tr>
                <td>197401837</td>
                <td>Rodger Fritz</td>
                <td>24 Dec, 2021</td>
                <td>Completed</td>
                <td class="text-success">$237.90</td>
            </tr>
            </tbody>
        </table>
    </div>

</@main.layout>
