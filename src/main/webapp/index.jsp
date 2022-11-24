<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
    <link href=my.css" rel="stylesheet">
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<div class="container bgcont center-block">
    <div class="row background-row">
        <div class="centered-top">
            <div class="p-3 mb-2 bg-light text-dark">
                <figure class="text-center">
                    <blockquote class="blockquote">
                        <p>Однажды весенним утром, ты проснулся и как всегда сварил себе чашечку кофе.
                            Ты подошел к окну что бы насладится видом на лес из своей квартиры,
                            но эту минуту покоя нарушил твой верный друг "Джек", так звали маленького джека рассела,
                            который достался тебе от бывшей жены. Конечно, его уже давно пора было выгулять.
                            Ты собрался и отправился на прогулку в лес, в лесу ты решил отпустить Джека с поводка, и
                            конечно
                            же он помчался в самую чащу. Попытавшись его догнать, ты споткнулся о ветку
                            и упал ударившись головой о камень. Когда ты очнулся было уже совсем темно...</p>
                    </blockquote>
                </figure>
                <br/>
                <form action="gameServlet">
                    <br>
                    <br>
                    <div class="input-group mb-3">
                        <input name="name" type="text" class="form-control" placeholder="Введите имя"
                               aria-label="Recipient's username" aria-describedby="button-addon2">
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Начать игру</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</html>