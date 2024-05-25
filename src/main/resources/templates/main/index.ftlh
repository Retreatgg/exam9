<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <div class="container mt-4">
        <nav class="navbar navbar-light bg-light">
            <span class="navbar-brand mb-0 h1">Recent Transactions</span>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </nav>

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
        <button class="btn btn-primary">Download the Excel File</button>
        <nav aria-label="Page navigation example" class="mt-3">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>
    </div>

</@main.layout>
