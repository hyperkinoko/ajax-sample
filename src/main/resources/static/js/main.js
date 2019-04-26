/**
 * Created by superkinoko on 2017/07/15.
 */
$(function() {
    var $win = $(window),
        $main = $('#body-wrap'),
        $nav = $('#top-header'),
        navHeight = $nav.outerHeight(),
        navPos = $nav.offset().top,
        fixedClass = 'is-fixed';

    // スクロールした時にメニューバーを固定するスクリプト
    $win.on('load scroll', function() {
        var value = $(this).scrollTop();
        if ( value > navPos ) {
            $nav.addClass(fixedClass);
            $main.css('margin-top', navHeight);
        } else {
            $nav.removeClass(fixedClass);
            $main.css('margin-top', '0');
        }
    });

    // バーガーメニューをクリックしたらメニューが出てきたり消えたりするスクリプト
    $('#nav-toggle div').click(function() {
        console.log("togglebutton pushed");
        $('#menu-top').toggleClass('open');
        $('#nav-toggle').toggleClass('open');
    });

    $.ajax({
        url: './open',
        type: 'GET',
        // dataType: 'json',
        // // フォーム要素の内容をハッシュ形式に変換
        // data: $('form').serializeArray(),
        timeout: 5000,
    })
        .done(function(data) {
            console.log("success");
            console.log(data);
            dispdata(data);
        })
        .fail(function() {
            // 通信失敗時の処理を記述
        });
});

function dispdata(data) {
    $('.calender').html(data);
}

