<#import "../layout.ftlh" as main>
<@main.layout>

    <div class="container my-4">
        <div class="mt-4">
            <div class="row">
                <#list providers as p>
                    <div class="col-md-3">
                        <div class="card bg-primary text-white p-3 mb-4">
                            <div class="card-body d-flex flex-column align-items-center">
                                <p class="card-text mb-2">${p.getName()}</p>
                                <a href="/provider/${p.id}" class="btn btn-light btn-sm mb-2">Перейти на страницу</a>
                                <button class="btn btn-light btn-sm" data-toggle="modal" data-target="#providerModal-${p.id}">Подробнее</button>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>

        <!-- Modal for each provider -->
        <#list providers as p>
            <div class="modal fade" id="providerModal-${p.id}" tabindex="-1" role="dialog" aria-labelledby="providerModalLabel-${p.id}" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="providerModalLabel-${p.id}">${p.getName()}</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <h2>TEste</h2>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">More actions</button>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
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
