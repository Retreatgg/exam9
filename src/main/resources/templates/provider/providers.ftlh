<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <div class="container my-4">
        <div class="mt-4">
            <div class="row">
                <#list providers as p>
                    <div class="col-md-3">
                        <div class="card bg-primary text-white p-3 mb-4">
                            <div class="card-body d-flex flex-column align-items-center">
                                <p class="card-text mb-2">${p.getName()}</p>
                                <a href="/provider/${p.account}" class="btn btn-light btn-sm mb-2"><@spring.message "providers.link"/></a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>


    </div>

    <style>
        .card {
            width: 100%;
            height: auto;
            text-align: center;
            border-radius: 8px;
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .card-text {
            line-height: 1.5;
            font-size: 1.2rem;
            font-weight: bold;
        }

        .btn-light {
            background-color: #fff;
            color: #000;
            border: 1px solid #ddd;
            margin-top: 10px;
            transition: background-color 0.2s, color 0.2s;
        }

        .btn-light:hover {
            background-color: #f8f9fa;
            color: #007bff;
        }

        .modal-header {
            background-color: #007bff;
            color: white;
        }

        .modal-footer .btn-secondary {
            background-color: #6c757d;
        }

        .modal-footer .btn-primary {
            background-color: #007bff;
        }
    </style>

</@main.layout>
