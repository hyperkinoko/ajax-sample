/**
 * Created by superkinoko on 2017/07/15.
 */

//カレンダー出力用
let year;
let month;
let openData;

$(function() {
    const $win = $(window);
    const $main = $('#body-wrap');
    const $nav = $('#top-header');
    const navHeight = $nav.outerHeight();
    const navPos = $nav.offset().top;
    const fixedClass = 'is-fixed';

    // カレンダーを表示する
    const now = new Date();
    year = now.getFullYear();
    month = now.getMonth() + 1;
    dispCalender();

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
        // console.log("togglebutton pushed");
        $('#menu-top').toggleClass('open');
        $('#nav-toggle').toggleClass('open');
    });
});

function dispCalender() {
    // console.log("year: " + year + " month: " + month);
    dispCalenderOfMonth(year, month);
    let nextMonth = month + 1;
    let nextYear = year;
    if(nextMonth === 13) {
        nextMonth = 1;
        nextYear++;
    }
    // console.log("year: " + nextYear + " month: " + nextMonth);
    dispCalenderOfMonth(nextYear, nextMonth);

    // 空き状況を表示する
    getAndReflectOpenData();
}

function dispCalenderOfMonth(year, month) {
    $('.calender-wrapper').append('<div class="calender"></div>');
    $('div.calender:last').append('<h3>' + month + '月</h3>');
    $('div.calender:last').append('<table></table>');
    const firstDay = new Date(year, month - 1, 1);
    const lastDay = new Date(year, month, 0);

    //1日の曜日に合わせて空の<td>を出力する(開始日が日曜日以外）
    if (firstDay.getDay() !== 0) {
        $('div.calender table:last').append('<tr></tr>');
        for (let youbi = 0; youbi < firstDay.getDay(); youbi++) {
            $('tr:last').append('<td></td>');
        }
    }

    let dayCount = 1;
    while (dayCount <= lastDay.getDate()) {
        const day = new Date(year, month - 1, dayCount);

        // 日曜日だったら新しい行を用意する
        if (day.getDay() === 0) {
            $('div.calender table:last').append('<tr></tr>');
        }

        $('div.calender tr:last').append('<td>' + dayCount + '</td>');
        $('div.calender td:last').attr('id', day.getFullYear() + '-' + ("0" + (day.getMonth() + 1)).substr(-2) + '-' + ("0" + day.getDate()).substr(-2));

        dayCount++;
    }
}

function getAndReflectOpenData() {
    $.ajax({
        url: './open',
        type: 'GET',
        // dataType: 'json',
        // // フォーム要素の内容をハッシュ形式に変換
        // data: $('form').serializeArray(),
        timeout: 5000,
    })
        .done(function(data) {
            openData = JSON.parse(JSON.stringify(data));
            reflect();
        })
        .fail(function() {
            // 通信失敗時の処理を記述
        });
}

function reflect() {
    // 文字列をDateに変換
    openData.forEach(open => {
        open.startDatetime = open.startDatetime.replace("+0000", "Z");
        open.endDatetime = open.endDatetime.replace("+0000", "Z");
        open.startDatetime = new Date(open.startDatetime);
        open.endDatetime = new Date(open.endDatetime);
    });
    // console.log(openData);
    for(let index = 0; index < 2; index++) {
        let lastDayOfMonth = new Date(year, month + index, 0);

        let dayCount = 1;
        while (dayCount <= lastDayOfMonth.getDate()) {
            // <td>のidのための文字列を生成
            const dayString = year + "-" + ("0" + (month + index)).substr(-2) + "-" + ("0" + dayCount).substr(-2);
            // データの中にその日付があれば空きありクラスをつける
            const exists = openData.some(d => d.startDatetime.getFullYear() === year && d.startDatetime.getMonth() === month + index - 1 && d.startDatetime.getDate() === dayCount);
            if (exists) {
                $('#' + dayString).addClass('open');
            }
            dayCount++;
        }
    }
}
