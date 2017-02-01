SUMMARY = "Open Content Decryption Module."
HOMEPAGE = "https://www.fokus.fraunhofer.de/en"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea83f8bc099c40bde8c4f2441a6eb40b"

DEPENDS = "glib-2.0" 

SRCREV = "1e64a23ded5e64df0ae62f52c4114f2ed54b1f04"
PV = "1.0.gitr${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://git@github.com/fraunhoferfokus/open-content-decryption-module.git;protocol=ssh;branch=2357_ppapi_chromium"
SRC_URI += "file://0001-opencdm-wpe.patch \
"

do_compile_prepend() {
	mkdir -p ${S}/src/browser/wpe/test/bin
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/src/browser/wpe/bin/ocdm_client ${D}${bindir}
    install -m 0755 ${B}/src/browser/wpe/bin/ocdm_decryptor ${D}${bindir}

	install -d ${D}${libdir}
	install -m 0755 ${B}/src/browser/wpe/lib/libocdm.so ${D}${libdir}
}

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
