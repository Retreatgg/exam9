<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <div class="container content">
        <h2>My Wallet</h2>
        <p>Keep track of your financial plan</p>
        <div class="wallet-card mb-4">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <h3>👋 Hi Adrian!</h3>
                    <h1>$124,543</h1>
                </div>
                <div>
                    <button class="btn btn-outline-primary">Send a payment</button>
                    <button class="btn btn-outline-primary">Request a payment</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="wallet-item">
                    <h5>Emergency fund</h5>
                    <p>Last Paid on August 28, 2022</p>
                    <h6>$300 / $1000</h6>
                    <div class="progress">
                        <div class="progress-bar bg-primary" role="progressbar" style="width: 30%;" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wallet-item">
                    <h5>Travel Plan</h5>
                    <p>Last Paid on June 01, 2022</p>
                    <h6>$10,000 / $20,000</h6>
                    <div class="progress">
                        <div class="progress-bar bg-primary" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wallet-item">
                    <h5>Education</h5>
                    <p>Last Paid on May 14, 2022</p>
                    <h6>$7,000 / $10,000</h6>
                    <div class="progress">
                        <div class="progress-bar bg-primary" role="progressbar" style="width: 70%;" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wallet-item">
                    <h5>Foods and Groceries</h5>
                    <p>Last Paid on August 28, 2022</p>
                    <h6>$300 / $1000</h6>
                    <div class="progress">
                        <div class="progress-bar bg-primary" role="progressbar" style="width: 30%;" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wallet-item">
                    <h5>Repair Vehicle</h5>
                    <p>Last Paid on August 01, 2022</p>
                    <h6>$900 / $1000</h6>
                    <div class="progress">
                        <div class="progress-bar bg-primary" role="progressbar" style="width: 90%;" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="wallet-item">
                    <h5>Donation</h5>
                    <p>Last Paid on August 20, 2022</p>
                    <h6>$200 / $1000</h6>
                    <div class="progress">
                        <div class="progress-bar bg-primary" role="progressbar" style="width: 20%;" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center mt-4">
            <button class="btn btn-primary">Create New Wallet</button>
        </div>
    </div>

</@main.layout>
