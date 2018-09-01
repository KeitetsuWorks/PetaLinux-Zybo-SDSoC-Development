SUMMARY = "ZD1211 USB WLAN Linux Driver"
SECTION = "kernel"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://zd1211-firmware/COPYING;md5=eb723b61539feef013de476e68b5c50a"

SRC_URI = "https://sourceforge.net/projects/zd1211/files/zd1211-firmware/1.5/zd1211-firmware-1.5.tar.bz2 \
    "

SRC_URI[md5sum] = "3c182ceb9b2fc1d8442cd81c1280d83f"
SRC_URI[sha256sum] = "f11d3810d7f72833997f634584a586dcced71a353f965abf81062ec431d02b12"

S = "${WORKDIR}"

do_compile() {
    :
}

do_install() {
    install -d ${D}/lib/firmware/zd1211
    install -m 0644 ${S}/zd1211-firmware/zd1211* ${D}/lib/firmware/zd1211
    install -m 0644 ${S}/zd1211-firmware/COPYING ${D}/lib/firmware/zd1211
}

FILES_${PN} = "/lib/firmware/zd1211/zd1211* \
               /lib/firmware/zd1211/COPYING \
    "
