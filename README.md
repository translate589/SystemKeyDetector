# SystemKeyDetector
안드로이드 폰 시스템 키 디텍터

HomeKey, RecentKey(최근 사용 키), ScreenLock, Assistant(구글 어시스턴트 등) 호출 이벤트를 캐치한다.

* 앱 실행 중에만 Broadcast를 받는다. Manifest에 등록해도 신호가 오지 않는다.
* 안드로이드 OS 버전에 따라 reason이 다르다.
