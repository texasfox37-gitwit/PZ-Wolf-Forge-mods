# Release Checklist

Use this checklist before publishing the public GitHub Release.

## Package Checks

1. Verify the zip contents.
2. Confirm the package contains only the simple public bridge files:
   - `README.txt`
   - `installer.bat`
   - `uninstaller.bat`
   - `TDDUPJavaCombatBridge.jar`
   - `TTDUP_NPC_RenderBridge.jar`
3. Confirm the package does not contain FirearmAuthority, private body bridge jars, DirectFire test jars, report-only helpers, verify helpers, restore helpers, or extra installer tools.
4. Confirm there are no Steam credentials, GitHub tokens, personal files, private notes, or local machine paths that should not be public.
5. Confirm there are no auto-downloaders, telemetry hooks, or background-service installers.

## Repository Checks

1. Generate SHA256 checksums for the release zip.
2. Update `SHA256SUMS.txt`.
3. Update `VERSION.txt`.
4. Commit the docs and release-management files.
5. Push to GitHub.

## GitHub Pages

1. Confirm GitHub Pages is still enabled from the `main` branch and `/docs` folder.
2. Wait for GitHub Pages to publish.
3. Open the published Pages URL and confirm the install, uninstall, troubleshooting, security, and Workshop pages display correctly.

## GitHub Release

1. Draft a new GitHub Release.
2. Tag it:

```text
v3.6-simple-two-jar
```

3. Use a clear title:

```text
TDDUP Public Java Bridge v3.6 - Simple Two-Jar Package
```

4. Upload this release asset:

```text
TDDUP_Public_JavaBridge_v3_6_SIMPLE_TWO_JAR.zip
```

5. Include the checksum from `SHA256SUMS.txt` in the release notes.
6. Mention that v3.6 preserves other mods' Java entries, preserves memory settings, and installs only the two public TDDUP bridge jars.
7. Publish the release.
8. Copy the final GitHub Release URL.
9. Replace `REPLACE_WITH_YOUR_GITHUB_RELEASE_URL` in the Steam Workshop description text.
10. Update the Steam Workshop description.

## Final Smoke Check

1. Confirm the Steam Workshop text says the external Java Bridge is required.
2. Confirm the docs do not say the Workshop item works by itself.
3. Confirm the GitHub Release asset downloads correctly.
4. Confirm the release zip checksum matches `SHA256SUMS.txt`.
