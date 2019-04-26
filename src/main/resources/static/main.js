var year;
var month;
var course;

$(function() {
    year = getParam('year');
    month = getParam('month');
    course = getParam('course');

    if(year === null) {
        year = new Date().getFullYear();
    }
    if(month === null) {
        month = new Date().getMonth();
    }
    if(course === null) {
        course = 'junior';
    }

    dispCalender(0);

    month++;
    if(month >= 12) {
        month = 0;
        year++;
    }

    dispCalender(1);
});

function dispCalender(index) {
    $('.calender-title').eq(index).append((month + 1) + "月");

    $.ajax({
        type: 'POST',
        url: '/'
    })
}

/**
 * Get the URL parameter value
 *
 * @param  name {string} パラメータのキー文字列
 * @return  url {url} 対象のURL文字列（任意）
 */
function getParam(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
