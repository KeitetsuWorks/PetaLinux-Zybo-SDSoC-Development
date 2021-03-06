SUMMARY = "Firmware files for use with Linux kernel"
SECTION = "kernel"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = " \
    file://LICENCE.ralink-firmware.txt;md5=ab2c269277c45476fb449673911a2dfd \
    file://LICENCE.rtlwifi_firmware.txt;md5=00d06cfd3eddd5a2698948ead2ad54a5 \
    "

SRCREV = "fea76a04f25fd0a217c0d566ff5ff8f23ad3e648"

PV = "0.0+git${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}/lib/firmware
    install -m 0644 ${S}/rt*.bin ${D}/lib/firmware
    install -m 0644 ${S}/LICENCE.ralink-firmware.txt ${D}/lib/firmware
    install -d ${D}/lib/firmware/rtlwifi
    install -m 0644 ${S}/rtlwifi/* ${D}/lib/firmware/rtlwifi
    install -m 0644 ${S}/LICENCE.rtlwifi_firmware.txt ${D}/lib/firmware
}

FILES_${PN} = " \
    /lib/firmware/rt*.bin \
    /lib/firmware/LICENCE.ralink-firmware.txt \
    /lib/firmware/rtlwifi/* \
    /lib/firmware/LICENCE.rtlwifi_firmware.txt \
    "
